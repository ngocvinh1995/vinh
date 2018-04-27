import { Component,OnDestroy, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../course.service";
import {Course} from "../Course";
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-course-create',
  templateUrl: './course-create.component.html',
  styleUrls: ['./course-create.component.css'],
  providers: [CourseService]
})
export class CourseCreateComponent implements OnInit ,OnDestroy {

  id: number;
  course: Course;

  courseForm: FormGroup;
  private sub: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private courseService: CourseService) { }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
    this.id = params['id'];
      });

      this.courseForm = new FormGroup({
        Name: new FormControl('', Validators.required)
      });

      if (this.id) { //edit form
     this.courseService.findById(this.id).subscribe(
       course => {
           this.id = course.id;
           this.courseForm.patchValue({
           Name: course.name,
         });
        },error => {
         console.log(error);
        }
     );

   }
  }
  ngOnDestroy(): void {
     this.sub.unsubscribe();
    }

    onSubmit() {
      if (this.courseForm.valid) {
        if (this.id) {
          let course: Course = new Course(this.id,
           this.courseForm.controls['Name'].value);
         this.courseService.updateCourse(course).subscribe();
      } else{
          let course: Course = new Course(null,
          this.courseForm.controls['Name'].value);
          this.courseService.saveCourse(course).subscribe();
       }

        this.courseForm.reset();
        this.router.navigate(['/course']);
    }
  }

  redirectCoursePage() {
      this.router.navigate(['/course']);

    }
}
