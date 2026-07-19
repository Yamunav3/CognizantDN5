import CohortDetails from './components/CohortDetails';
import cohorts from './cohortsData';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Cohorts Details</h1>
      {cohorts.map((cohort) => (
        <CohortDetails
          key={cohort.id}
          name={cohort.name}
          startedOn={cohort.startedOn}
          currentStatus={cohort.currentStatus}
          coach={cohort.coach}
          trainer={cohort.trainer}
        />
      ))}
    </div>
  );
}

export default App;
