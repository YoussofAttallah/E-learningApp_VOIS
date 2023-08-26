import React, { useState } from "react";
import axios from "axios";
// **Created a new css file and imported it**
import "./addInstructorForm.css";

function AddInstructorForm() {
  const [instructorName, setinstructorName] = useState("");
  const [link, setLink] = useState("");


  const handleSubmit = async (e) => {
    e.preventDefault();

    const newInstructor = {
      instructorName,
      link,
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/api/instructor",
        newInstructor
      );
      console.log("Instructor added:", response.data);
      // Handle success or navigation to a different view
    } catch (error) {
      console.error("Error adding Instructor:", error);
    }
  };

  return (
    // **Added Clase Name**
    <div className="add-course-section">
      <form onSubmit={handleSubmit}>
        <h2>Add New Instructor</h2>
        {/* // **Added a div around every label and input** */}

        <div>
          <label>Instructor Name:</label>
          <input
            type="text"
            value={instructorName}
            onChange={(e) => setinstructorName(e.target.value)}
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

        {/* <div>
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
        </div> */}
        <button type="submit">Add Instructor</button>
      </form>
    </div>
  );
}

export default AddInstructorForm;
