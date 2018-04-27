import { Injectable } from '@angular/core';
import { Course } from "./course";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";

@Injectable()
export class CourseService {

 private apiUrl = 'http://localhost:8080/courses';

  constructor(private http: Http) { }

  findAll(): Observable<Course[]>  {
   return this.http.get(this.apiUrl)
     .map((res:Response) => res.json())
     .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
 }

 findById(id: number): Observable<Course> {
   console.log(this.apiUrl + '/' + id);
   return this.http.get(this.apiUrl + '/' + id)
     .map((res:Response) => res.json())
     .catch((error:any) => Observable.throw(error.json().error || 'Error'));
 }

 saveCourse(course: Course): Observable<Course> {
   return this.http.post(this.apiUrl, course)
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));

 }

 deleteCourseById(id: number): Observable<boolean> {
   return this.http.delete(this.apiUrl + '/' + id)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
 }

 updateCourse(course: Course): Observable<Course> {
   return this.http.put(this.apiUrl, course)
     .map((res:Response) => res.json())
     .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
 }


}
