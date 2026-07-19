import React from 'react';

// Data - Course Details
export const courses = [
  { id: 1, cname: 'Angular', cdate: '4/5/2021' },
  { id: 2, cname: 'React', cdate: '6/3/2021' }
];

// Conditional rendering technique 3: element variable built with a function, returned early if empty
function CourseDetails(props) {
  if (!props.courses || props.courses.length === 0) {
    return <p>No courses available.</p>;
  }

  const coursedet = props.courses.map((course) => (
    <div key={course.id}>
      <h3>{course.cname}</h3>
      <h4>{course.cdate}</h4>
    </div>
  ));

  return coursedet;
}

export default CourseDetails;
