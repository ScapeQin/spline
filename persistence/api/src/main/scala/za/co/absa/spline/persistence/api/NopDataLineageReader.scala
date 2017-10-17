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

package za.co.absa.spline.persistence.api

import java.util.UUID
import za.co.absa.spline.model.{DataLineage, PersistedDatasetDescriptor}
import scala.concurrent.Future

/**
  * The class represents a dummy reader that does not read any data from any persistence layer.
  */
class NopDataLineageReader extends DataLineageReader{
  /**
    * The method loads a particular data lineage from the persistence layer.
    *
    * @param id An unique identifier of a data lineage
    * @return A data lineage instance when there is a data lineage with a given id in the persistence layer, otherwise None
    */
  override def load(id: UUID): Future[Option[DataLineage]] = Future.successful(None)

  /**
    * The method loads the latest data lineage from the persistence for a given path.
    *
    * @param path A path for which a lineage graph is looked for
    * @return The latest data lineage
    */
  override def loadLatest(path: String): Future[Option[DataLineage]] = Future.successful(None)

  /**
    * The method gets all data lineages stored in persistence layer.
    *
    * @return Descriptors of all data lineages
    */
  override def list(): Future[Iterator[PersistedDatasetDescriptor]] = Future.successful(Iterator.empty)

  /**
    * The method returns a dataset descriptor by its ID.
    *
    * @param id An unique identifier of a dataset
    * @return Descriptors of all data lineages
    */
  override def getDatasetDescriptor(id: UUID): Future[PersistedDatasetDescriptor] = `not applicable`
}
