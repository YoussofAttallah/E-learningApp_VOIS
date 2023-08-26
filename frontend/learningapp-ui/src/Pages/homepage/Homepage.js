import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Card from '../../Components/Card/Card';
import classes from './homepage.module.css'
const Homepage = () => {
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


            <h2 className={classes.allh}>All Courses</h2>
            <div className={classes.cardcontainer}>
                {courses.map(course => (
                    <Card key={course.id} course={course} />
                ))}
            </div>
        </div>
    );
}

export default Homepage;