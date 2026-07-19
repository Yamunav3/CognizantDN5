import React from 'react';

// Data - Blog Details
export const blogs = [
  { id: 1, btitle: 'React Learning', bauthor: 'Stephen Biz', bcontent: 'Welcome to learning React!' },
  { id: 2, btitle: 'Installation', bauthor: 'Schwzdenier', bcontent: 'You can install React from npm.' }
];

// Conditional rendering technique 2: ternary/&& inline within JSX
function BlogDetails(props) {
  return (
    <div>
      {props.blogs && props.blogs.length > 0 ? (
        props.blogs.map((blog) => (
          <div key={blog.id}>
            <h1>{blog.btitle}</h1>
            <b>{blog.bauthor}</b>
            <p>{blog.bcontent}</p>
          </div>
        ))
      ) : (
        <p>No blogs to display.</p>
      )}
    </div>
  );
}

export default BlogDetails;
