import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseCreateComponent } from './course-create/course-create.component';

const routes: Routes = [
  {path: 'course', component: CourseListComponent},
 {path: 'course/create', component: CourseCreateComponent},
 {path: 'course/edit/:id', component: CourseCreateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseRoutingModule { }
