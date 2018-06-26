  import React, { Component } from 'react';
  import logo from './logo.svg';
  import './App.css';

  let contactsData = require('./contacts.json').map(x => {
        <Contact firstName={x.firstName} lastName={x.lastName} />
      }).join(''); 
console.log(contactsData)

  class Header extends Component {
    render() {
      return (
    <header>&#9993; Contact Book</header>
      );
    }
  }

  class Contact extends Component {
    render() {
      return (
        <div className="contact" >
            <span className="avatar small">&#9787;</span>
            <span className="title">{this.props.firstName} {this.props.lastName}</span>
        </div>
      );
    }
  }

  class Content extends Component {
      constructor(props) {
        super(props);
        this.contactsData = require('./contacts.json').map(x => {
          <Contact firstName={x.firstName} lastName={x.lastName} />
         });
      }
       
    render() {
      return (
        <div>
        {contactsData}
        </div>
      );
    }
  }

  class App extends Component {
      render() {
      return (
        <div>
        <Header />
        <div id="book">
          <div id="list">
              <h1>Contacts</h1>
              
              <Content>
                
              </Content>
          </div>
          <div id="details">
              <h1>Details</h1>
              <div className="content">
                  <div className="info">
                      <div className="col">
                          <span className="avatar">&#9787;</span>
                      </div>
                      <div className="col">
                          <span className="name">Ivan</span>
                          <span className="name">Ivanov</span>
                      </div>
                  </div>
                  <div className="info">
                      <span className="info-line">&phone; 0887 123 456</span>
                      <span className="info-line">&#9993; i.ivanov@gmail.com</span>
                  </div>
              </div>
          </div>
      </div>
      </div>
      );
    }
  }

  export default App;
