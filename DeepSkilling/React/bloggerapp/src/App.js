import './App.css';
import BookDetails, { books } from './components/BookDetails';
import BlogDetails, { blogs } from './components/BlogDetails';
import CourseDetails, { courses } from './components/CourseDetails';

function App() {
  const bookdet = <BookDetails books={books} />;
  const content = <BlogDetails blogs={blogs} />;
  const coursedet = <CourseDetails courses={courses} />;

  return (
    <div>
      <div className="mystyle1">
        <h1> Course Details</h1>
        {coursedet}
      </div>
      <div className="st2">
        <h1> Book Details</h1>
        {bookdet}
      </div>
      <div className="v1">
        <h1> Blog Details</h1>
        {content}
      </div>
    </div>
  );
}

export default App;
