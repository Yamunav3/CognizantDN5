import React, { Component } from 'react';
import CurrencyConvertor from './components/CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handlePress = this.handlePress.bind(this);
  }

  increment() {
    this.setState({ count: this.state.count + 1 });
  }

  decrement() {
    this.setState({ count: this.state.count - 1 });
  }

  sayHello() {
    alert('Hello! Member1');
  }

  handleIncrementClick() {
    // The "Increase" button invokes two methods: increment the counter, then say hello.
    this.increment();
    this.sayHello();
  }

  sayWelcome(message) {
    alert(message);
  }

  handlePress = (event) => {
    // Synthetic event example
    alert('I was clicked');
  };

  render() {
    return (
      <div>
        <h2>{this.state.count}</h2>
        <button onClick={() => this.handleIncrementClick()}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayWelcome('welcome')}>Say welcome</button>
        <button onClick={this.handlePress}>Click on me</button>

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
