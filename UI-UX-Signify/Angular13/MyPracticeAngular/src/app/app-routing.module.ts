import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponentComponent } from './Component/home-component/home-component.component';
import { MyComponentComponent } from './Component/my-component/my-component.component';
import { UserComponentComponent } from './Component/user-component/user-component.component';
//we have to define all the navigation rules in the form of routes in angular with the following config


const routes: Routes = [

  { path:'' , redirectTo:'home' ,pathMatch:'full'},
  { path:'home' , component: HomeComponentComponent},
  { path:'grade' , component: MyComponentComponent},
  { path:'students' , component: UserComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
