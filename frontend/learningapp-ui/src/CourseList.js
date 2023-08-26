import React, { useState, useEffect } from 'react';
import axios from 'axios';
import CourseCard from './CourseCard'; 
const CourseList=() => {
    const [courses, setCourses] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/courses')
            .then(response => {
                setCourses(response.data);
            })
            .catch(error => {
                console.error('Error fetching courses:', error);
            });
    }, []);

    return (
        <div >
          

            <h2 >All Courses</h2>
            {courses.map(course => (
                <CourseCard key={course.id} course={course} />
            ))}
        </div>
    );
}

export default CourseList;
