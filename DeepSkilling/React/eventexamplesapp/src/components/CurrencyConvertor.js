 import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: ''
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit(event) {
    const euroAmount = Number(this.state.amount) * 80;
    var msg = 'Converting to ' + this.state.currency + ' Amount is ' + euroAmount;
    alert(msg);
    event.preventDefault();
  }

  render() {
    return (
      <div>
        <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <label>
            Amount:
            <input type="text" name="amount" value={this.state.amount} onChange={this.handleChange} />
          </label>
          <br />
          <label>
            Currency:
            <input type="text" name="currency" value={this.state.currency} onChange={this.handleChange} />
          </label>
          <br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
