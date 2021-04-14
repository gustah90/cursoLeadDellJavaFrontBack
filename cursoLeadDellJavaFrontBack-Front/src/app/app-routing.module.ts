import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PrimeiroComponentComponent } from './primeiro-component/primeiro-component.component';
import { SegundoComponentComponent } from './segundo-component/segundo-component.component';


const routes: Routes = [
  {path: "primeiro-component", component: PrimeiroComponentComponent },
  {path: "segundo-component", component: SegundoComponentComponent },
  {path: "**", component: PrimeiroComponentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
