import React from 'react';
import EmployeeCard from './EmployeeCard';

const employees = [
  { id: 1, name: 'Aathma', role: 'Coach' },
  { id: 2, name: 'Jojo Jose', role: 'Trainer' },
  { id: 3, name: 'Elisa Smith', role: 'Trainer' }
];

// Theme is no longer received or passed as a prop - EmployeeCard reads it
// directly from ThemeContext instead.
function EmployeeList() {
  return (
    <div className="employee-list">
      {employees.map((employee) => (
        <EmployeeCard key={employee.id} employee={employee} />
      ))}
    </div>
  );
}

export default EmployeeList;
