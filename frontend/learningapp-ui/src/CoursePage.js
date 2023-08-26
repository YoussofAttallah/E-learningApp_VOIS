import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

function CoursePage() {
    const navigate = useNavigate();
    const { id } = useParams();
    const [course, setCourse] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:8080/api/courses/findById/${id}`)
            .then(response => {
                setCourse(response.data);
            })
            .catch(error => {
                console.error('Error fetching course:', error);
            });
    }, [id]);
    const [userRating, setUserRating] = useState(0);

    const handleRate = async () => {
        if (userRating > 0 && userRating <= 5) {
            const newRating = {
                ratingNum: course.ratingNum + 1,
                totalRating: course.totalRating + userRating
            };

            try {
                await axios.put(`http://localhost:8080/api/courses/${id}`, newRating);
                // Handle success or update course state
            } catch (error) {
                console.error('Error rating course:', error);
            }
        }
    };
    const handleDelete = async() => {
        try {
            await axios.delete(`http://localhost:8080/api/courses/${id}`);
            navigate(`/all`)


        } catch (error) {
            console.error('Error deleting course:', error);
        }
    }
    if (!course) {
        return <div>Loading...</div>; // Handle loading state
    }
    return (
        <div className="course-page">
            <h2>{course.title}</h2>
            <img className="course-image" src={course.imageLink} alt={course.title} />
            <a href={course.link} target="_blank" rel="noopener noreferrer">Course Link</a>
            <p>Duration: {course.duration} hours</p>
            <p>Instructor: {course.instructor.instructorName}</p>
            <p>total ratings: {course.ratingNum}</p>
            <p>Average Rating: {course.totalRating / course.ratingNum}</p>

            <div>
                Rate this course:
                <select value={userRating} onChange={e => setUserRating(Number(e.target.value))}>
                    <option value={0}>Select rating</option>
                    <option value={1}>1</option>
                    <option value={2}>2</option>
                    <option value={3}>3</option>
                    <option value={4}>4</option>
                    <option value={5}>5</option>
                </select>
                <button onClick={handleRate}>Rate</button>
            </div>
            <button onClick={handleDelete}>Delete Course</button>
        </div>
    );
}

export default CoursePage;
