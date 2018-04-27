import { Component, OnInit } from '@angular/core';
import { Student } from "../student";
import { StudentService } from "../student.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  providers: [StudentService]
})
export class StudentListComponent implements OnInit {

   private students: Student[];

  constructor(private router: Router,
    private studentService: StudentService) { }

  ngOnInit() {
     this.getAllStudents();
  }

   getAllStudents() {
    this.studentService.findAll().subscribe(
      students => {
        this.students = students;
      },
      err => {
        console.log(err);
      }

    );
  }
  redirectNewStudentPage() {
    this.router.navigate(['/student/create']);
  }

  editStudentPage(student: Student) {
    if (student) {
      this.router.navigate(['/student/edit', student.id]);
    }
  }

  deleteStudent(student: Student) {
    if (student) {
     this.studentService.deleteStudentById(student.id).subscribe(
       res => {
         this.getAllStudents();
         this.router.navigate(['/student']);
         console.log('done');
       }
     );
   }
  }
}
