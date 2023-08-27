import React, { useState } from "react";
import axios from "axios";
import classes from "./addCourseform.module.css";
// **Created a new css file and imported it**
import "./addCourseform.css";

function AddCourseForm() {
  const [title, setTitle] = useState("");
  const [link, setLink] = useState("");
  const [duration, setDuration] = useState(0);
  const [imageLink, setImageLink] = useState("");
  const [instructorId, setInstructorId] = useState(0);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const newCourse = {
      title,
      link,
      duration,
      imageLink,
      instructor: {
        instructorId,
      },
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/api/courses",
        newCourse
      );
      console.log("Course added:", response.data);
      // Handle success or navigation to a different view
    } catch (error) {
      console.error("Error adding course:", error);
    }
  };

  return (
    // **Added Clase Name**
    <div className="add-course-section">
      <form onSubmit={handleSubmit}>
        <h2>Add New Course</h2>
        {/* // **Added a div around every label and input** */}

        <div>
          <label>Title:</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </div>

        <div>
          <label>Link:</label>
          <input
            type="url"
            value={link}
            onChange={(e) => setLink(e.target.value)}
          />
        </div>

        <div>
          <label>Duration (hours):</label>
          <input
            type="number"
            value={duration}
            onChange={(e) => setDuration(Number(e.target.value))}
          />
        </div>

        <div>
          <label>Image Link:</label>
          <input
            type="url"
            value={imageLink}
            onChange={(e) => setImageLink(e.target.value)}
          />
        </div>

        <div>
          <label>Instructor ID:</label>
          <input
            type="number"
            value={instructorId}
            onChange={(e) => setInstructorId(Number(e.target.value))}
          />
        </div>
        <button type="submit">Add Course</button>
      </form>
    </div>
  );
}

export default AddCourseForm;