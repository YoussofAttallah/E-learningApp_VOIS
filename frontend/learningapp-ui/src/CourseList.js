import React, { useState, useEffect } from 'react';
import axios from 'axios';
import CourseCard from './CourseCard'; 
import { Link } from 'react-router-dom';

function CourseList() {
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
        <div>
            <Link to="/add">Add Course</Link>

            <h2>All Courses</h2>
            {courses.map(course => (
                <CourseCard key={course.id} course={course} />
            ))}
        </div>
    );
}

export default CourseList;
