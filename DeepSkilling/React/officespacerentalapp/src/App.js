import './App.css';

const element = "Office Space";
// Replace this with a local image (e.g. `import officeImage from './office-space.jpg'`) if you have one.
const sr = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=400";
const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;

const offices = [
  { Name: 'DBS', Rent: 50000, Address: 'Chennai' },
  { Name: 'Prestige Towers', Rent: 65000, Address: 'Bangalore' },
  { Name: 'Skyline Business Park', Rent: 45000, Address: 'Hyderabad' }
];

function getColorClass(rent) {
  let colors = [];
  if (rent <= 60000) {
    colors.push('textRed');
  } else {
    colors.push('textGreen');
  }
  return colors.join(' ');
}

function App() {
  return (
    <div>
      <h1>{element}, at Affordable Range</h1>
      {jsxatt}

      {offices.map((ItemName) => (
        <div key={ItemName.Name}>
          <h1>Name: {ItemName.Name}</h1>
          <h3 className={getColorClass(ItemName.Rent)}>Rent: Rs. {ItemName.Rent}</h3>
          <h3>Address: {ItemName.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;
