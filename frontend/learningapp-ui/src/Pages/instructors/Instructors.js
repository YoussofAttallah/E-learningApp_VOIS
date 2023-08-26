import React, { useState, useEffect } from 'react';
import axios from 'axios';
import InstructorCard from '../../Components/InstructorCard/InstructorCard';
import classes from './Instructors.module.css'
const Homepage = () => {
    const [instructors, setInstructors] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/instructor/all')
            .then(response => {
                setInstructors(response.data);
            })
            .catch(error => {
                console.error('Error fetching instructors:', error);
            });
    }, []);

    return (
        <div >


            <h2 className={classes.allh}>All Instructors</h2>
            <div className={classes.cardcontainer}>
                {instructors.map(instructor => (
                    <InstructorCard key={instructor.instructorId} instructor={instructor} />
                ))}
            </div>
        </div>
    );
}

export default Homepage;