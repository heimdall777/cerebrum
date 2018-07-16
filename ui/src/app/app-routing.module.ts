import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListComponent } from './images/list/list.component';
import { NotFoundComponent } from './error/not-found/not-found.component';
import { GeneralErrorComponent } from './error/general-error/general-error.component';
import { AddComponent } from './images/add/add.component';
import { HomePageComponent } from './home/home-page/home-page.component';

const routes: Routes = [
    { path: '', component: HomePageComponent  },
    { path: 'images', component: ListComponent },
    { path: 'images/add', component: AddComponent },
    { path: 'error', component: GeneralErrorComponent },
    { path: '**', component:  NotFoundComponent }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
      ],
    exports: [RouterModule]
})
export class RoutingModule {

}
