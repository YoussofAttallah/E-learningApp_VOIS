import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
// **Imported Style.css file**
import "./styles.css";

function CoursePage() {
  const { id } = useParams();
  const [course, setCourse] = useState(null);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/courses/findById/${id}`)
      .then((response) => {
        setCourse(response.data);
      })
      .catch((error) => {
        console.error("Error fetching course:", error);
      });
  }, [id]);

  const [userRating, setUserRating] = useState(0);

  const handleRate = async () => {
    if (userRating > 0 && userRating <= 5) {
      const newRating = {
        ratingNum: course.ratingNum + 1,
        totalRating: course.totalRating + userRating,
      };

      try {
        await axios.put(`http://localhost:8080/api/courses/${id}`, newRating);
        // Handle success or update course state
      } catch (error) {
        console.error("Error rating course:", error);
      }
    }
  };
  if (!course) {
    return <div>Loading...</div>; // Handle loading state
  }
  return (
    // **Changed html structure, removed course link and made the photo a link, and finally added icons**
    <div className="course-page">
      <div className="course-image">
        <a href={course.link} target="_blank" rel="noopener noreferrer">
          <img src={course.imageLink} alt={course.title} />
        </a>
      </div>
      <div className="course-info">
        <h2>{course.title}</h2>

        {/* <a href={course.link} target="_blank" rel="noopener noreferrer">
          Course Link
        </a> */}
        <p>
          <img src="https://www.svgrepo.com/show/415565/clock-date-hour.svg" />
          Duration: <span>{course.duration} hours</span>
        </p>
        <p>
          <img src="https://www.svgrepo.com/show/493523/teacher-male.svg" />
          Instructor: <span>{course.instructor.instructorName}</span>
        </p>
        <p>
          <img src="https://www.svgrepo.com/show/356926/rating.svg" />
          total ratings: <span>{course.ratingNum}</span>
        </p>
        <p>
          <img src="https://www.svgrepo.com/show/247593/rating-rate.svg" />
          Average Rating: <span>{course.totalRating / course.ratingNum}</span>
        </p>

        <div>
          <div>
            Rate this course:{" "}
            <select
              value={userRating}
              onChange={(e) => setUserRating(Number(e.target.value))}
            >
              <option value={0}>Select rating</option>
              <option value={1}>1</option>
              <option value={2}>2</option>
              <option value={3}>3</option>
              <option value={4}>4</option>
              <option value={5}>5</option>
            </select>
          </div>
          <button onClick={handleRate}>Rate</button>
        </div>
      </div>
    </div>
  );
}

export default CoursePage;
