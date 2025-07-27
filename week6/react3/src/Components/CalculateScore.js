import React from 'react';
import '../Stylesheets/mystyle.css'; // Import the stylesheet

function CalculateScore(props) {
  const { Name, School, Total, Goal } = props;

  // Calculate the average score
  const averageScore = Total / Goal * 100; // Assuming Goal is the maximum possible score

  return (
    <div className="score-card">
      <h2>Student Score Details</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total Score:</strong> {Total}</p>
      <p><strong>Goal Score:</strong> {Goal}</p>
      <p className="average-score"><strong>Average Score:</strong> {averageScore.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;
