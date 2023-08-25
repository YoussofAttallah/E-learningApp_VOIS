import React from 'react';
import './styles.css';
import { Link } from 'react-router-dom';
function CourseCard({ course }) {
    console.log("data in courseCard",course)
    console.log("data for instructor", course["instructor"])
    if (!course || !course.instructor) {
        return <div>Loading...</div>; // Or any other fallback behavior
    }
    return (
        <Link to={`/course/${course.id}`} className="course-card-link">
        <div className="course-card">
            <img className="course-image" src={course.imageLink} alt={course.title} />
            <div className="course-details">
            <h2>{course.title}</h2>
            <p>Duration: {course.duration} hours</p>
            <p>Viewers: {course.viewersNum}</p>
            <p>Rating: {course.totalRating}</p>
            <a href={course.link} target="_blank" rel="noopener noreferrer">Course Link</a>

            <div className="instructor">
                <h3>Instructor: {course.instructor.instructorName}</h3>
                <p>Instructor Rating: {course.instructor.ratingTotal}</p>
                <a href={course.instructor.link} target="_blank" rel="noopener noreferrer">Instructor Link</a>
            </div>
            </div>
        </div>
        </Link>
    );
}

export default CourseCard;
