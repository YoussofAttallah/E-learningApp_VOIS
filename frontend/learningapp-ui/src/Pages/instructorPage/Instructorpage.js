import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

function InstructorPage() {
    const navigate = useNavigate();
    const { id } = useParams();
    const [instructor, setInstructor] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:8080/api/instructor/${id}`)
            .then(response => {
                setInstructor(response.data);
            })
            .catch(error => {
                console.error('Error fetching instructor:', error);
            });
    }, [id]);
    const [userRating, setUserRating] = useState(0);

    const handleRate = async () => {
        if (userRating > 0 && userRating <= 5) {
            const newData = {
                instructorId: instructor.instructorId,
                instructorName:instructor.instructorName,
                ratingNum: instructor.ratingNum + 1,
                ratingTotal: instructor.ratingTotal + userRating,
                link : instructor.link,
                courses: instructor.courses

            };
            console.log(newData);
            try {
                await axios.put(`http://localhost:8080/api/instructor/${id}`, newData);
                // Handle success or update course state
            } catch (error) {
                console.error('Error rating instructor:', error);
            }
        }
    };
    const handleDelete = async () => {
        try {
            await axios.delete(`http://localhost:8080/api/instructor/${id}`);
            navigate(`/instructor/all`)


        } catch (error) {
            console.error('Error deleting instructor:', error);
        }
    }
    if (!instructor) {
        return <div>Loading...</div>; // Handle loading state
    }
    return (
        <div className="course-page">
            <h2>{instructor.instructorName}</h2>
            <a href={instructor.link} target="_blank" rel="noopener noreferrer">instructor Link</a>
            <p>total ratings: {instructor.ratingNum}</p>
            <p>Average Rating: {instructor.ratingTotal / instructor.ratingNum}</p>

            <div>
                Rate this instructor:
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
            <button onClick={handleDelete}>Delete instructor</button>
        </div>
    );
}

export default InstructorPage;
