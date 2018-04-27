import { Component, OnInit } from '@angular/core';
import { Course } from "../course";
import { CourseService } from "../course.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css'],
  providers: [CourseService]
})
export class CourseListComponent implements OnInit {

  private courses: Course[];

  constructor(private router: Router,
              private courseService: CourseService) { }

  ngOnInit() {
     this.getAllCourses();
  }
  getAllCourses() {
   this.courseService.findAll().subscribe(
     courses => {
       this.courses = courses;
     },
     err => {
       console.log(err);
     }

   );
 }
 redirectNewCoursePage() {
    this.router.navigate(['/course/create']);
  }

  editCoursePage(course: Course) {
    if (course) {
      this.router.navigate(['/course/edit', course.id]);
    }
  }
  deleteCourse(course: Course) {
   if (course) {
     this.courseService.deleteCourseById(course.id).subscribe(
       res => {
         this.getAllCourses();
         this.router.navigate(['/course']);
         console.log('done');
       }
     );
   }
 }
}
