/*
 * Copyright 2017 Barclays Africa Group Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.co.absa.spline.persistence.mongo

import java.util.UUID.randomUUID

import za.co.absa.spline.model.{DataLineage, dt, expr, op}
import za.co.absa.spline.model.op.OperationProps

class MongoDataLineageWriterSpec extends MongoDataLineagePersistenceSpecBase {

  private val lineage = createDataLineage("appID", "appName")

  "Store method" should "store data lineage to a database." in {
    for {
      _ <- mongoWriter store lineage
      storedLineage <- mongoReader loadByDatasetId lineage.rootDataset.id
    } yield
      storedLineage shouldEqual Option(lineage)
  }

  "Fields with dots" should "be stored correctly" in {
    val lineageWithDotsAndDollar = {
      val dummyExpression = expr.Generic("", "", dt.Simple("", nullable = true), Nil)
      val aggregateOperationWithDotsAnd$ =
        op.Aggregate(OperationProps(randomUUID, "aggregate", Nil, randomUUID), Nil, Map("field.with.dots.and.$" -> dummyExpression))
      lineage.copy(operations = lineage.operations :+ aggregateOperationWithDotsAnd$)
    }

    for {
      _ <- mongoWriter store lineageWithDotsAndDollar
      storedLineage <- mongoReader loadByDatasetId lineageWithDotsAndDollar.rootDataset.id
    } yield
      storedLineage shouldEqual Option(lineageWithDotsAndDollar)
  }
}
