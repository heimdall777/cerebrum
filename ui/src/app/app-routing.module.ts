import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GreetingsComponent } from './greetings/greetings.component';
import { ListComponent } from './images/list/list.component';
import { NotFoundComponent } from './error/not-found/not-found.component';
import { GeneralErrorComponent } from './error/general-error/general-error.component';
import { AddComponent } from './images/add/add.component';

const routes: Routes = [
    { path: '', component: GreetingsComponent },
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
