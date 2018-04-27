import { Component, OnDestroy, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {StudentService} from "../student.service";
import {Student} from "../student";
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css'],
  providers: [StudentService]
})
export class StudentCreateComponent implements OnInit, OnDestroy {

  id: number;
  student: Student;

    studentForm: FormGroup;
    private sub: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private studentService: StudentService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
    this.id = params['id'];
    });

    this.studentForm = new FormGroup({
     Name: new FormControl('', Validators.required),
     Age: new FormControl('', Validators.required),
     Address: new FormControl('', Validators.required)
   });


   if (this.id) { //edit form
     this.studentService.findById(this.id).subscribe(
       student => {
           this.id = student.id;
           this.studentForm.patchValue({
           Name: student.name,
           Age: student.age,
           Address: student.address,
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

    if (this.studentForm.valid) {
      if (this.id) {
        let student: Student = new Student(this.id,
        this.studentForm.controls['Name'].value,
        this.studentForm.controls['Age'].value,
        this.studentForm.controls['Address'].value);
      this.studentService.updateStudent(student).subscribe(
      );
    } else {
        let student: Student = new Student(null,
        this.studentForm.controls['Name'].value,
        this.studentForm.controls['Age'].value,
        this.studentForm.controls['Address'].value);
        this.studentService.saveStudent(student).subscribe();
     }

      this.studentForm.reset();
      this.router.navigate(['/student']);
  }
}
  redirectStudentPage() {
    this.router.navigate(['/student']);

  }
}
