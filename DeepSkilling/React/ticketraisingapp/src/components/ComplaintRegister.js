import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: 0
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit(event) {
    const referenceNumber = Math.floor(Math.random() * 100);
    this.setState({ NumberHolder: referenceNumber }, () => {
      var msg = 'Thanks ' + this.state.ename + ' \n Your Complaint was Submitted \n Transaction ID is: ' + this.state.NumberHolder;
      alert(msg);
    });
    event.preventDefault();
  }

  render() {
    return (
      <div>
        <h1 style={{ color: 'red' }}>Register your complaints here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <label>
            Name:
            <input type="text" name="ename" value={this.state.ename} onChange={this.handleChange} />
          </label>
          <br />
          <label>
            Complaint:
            <textarea name="complaint" value={this.state.complaint} onChange={this.handleChange} />
          </label>
          <br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
