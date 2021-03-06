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

// CSS, Icons and other UI frameworks stuff
import "font-awesome/css/font-awesome.min.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/css/bootstrap-theme.min.css";
import "@angular/material/prebuilt-themes/indigo-pink.css";
import {MaterialModule} from "../material-extension/material.module";

// Other imports
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HttpModule} from "@angular/http";
import {DashboardComponent} from "./dashboard.component";
import {DatasetBrowserComponent} from "./dataset-browser/dataset-browser.component";
import {DatasetBrowserService} from "./dataset-browser/dataset-browser.service";
import {WelcomeComponent} from "./welcome/welcome.component";
import {MiscModule} from "../misc/misc.module";

@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        HttpModule,
        MaterialModule,
        MiscModule
    ],
    declarations: [
        DashboardComponent,
        DatasetBrowserComponent,
        WelcomeComponent
    ],
    providers: [
        DatasetBrowserService
    ],
    exports: [
        DashboardComponent,
        WelcomeComponent
    ]
})
export class DashboardModule {
}