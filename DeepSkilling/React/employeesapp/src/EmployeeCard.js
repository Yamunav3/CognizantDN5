import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div className={`employee-card ${theme}`}>
      <h3>{employee.name}</h3>
      <p>{employee.role}</p>
      <button className={theme}>View Profile</button>
      <button className={theme}>Message</button>
    </div>
  );
}

export default EmployeeCard;
