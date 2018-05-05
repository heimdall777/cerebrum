import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GreetingsComponent } from './greetings/greetings.component';
import { ListComponent } from './images/list/list.component';

const routes: Routes = [
    { path: '', component: GreetingsComponent },
    { path: 'images', component: ListComponent }
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
      ],
    exports: [RouterModule]
})
export class RoutingModule {

}
