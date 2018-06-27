import React, { Component } from 'react'; 
import './App.css';

let contactsData = require('./contacts.json');
let currentId = 0;

class Header extends Component {
    render() {
        return (
            <header>&#9993; Contact Book</header>
        );
    }
}

class Footer extends Component {
    render() {
        return (
            <footer>Contact Book SPA &copy; 2017</footer>
        );
    }
}

class Contact extends Component {
    render() {
        return (
            <div className="contact" key={this.props.index} data-id={this.props.index} onClick={this.props.click} >
            <span className="avatar small">&#9787;</span>
            <span className="title">{this.props.firstName} {this.props.lastName}</span>
            </div>
        );
    }
}

class ContactDetails extends Component {
    render() {
        return (
            <div className="content">
                <div className="info">
                    <div className="col">
                    <span className="avatar">&#9787;</span>
                    </div>
                    <div className="col">
                    <span className="name">{this.props.person.firstName}</span>
                    <span className="name">{this.props.person.lastName}</span>
                    </div>
                </div>
                <div className="info">
                    <span className="info-line">&#9742; {this.props.person.phone}</span>
                    <span className="info-line">&#9993; {this.props.person.email}</span>
                </div>
            </div> 
        ); 
    }
}

class Content extends Component {
    constructor(props) {
        super(props);
        this.state = {
            contacts: contactsData.map((x, i) => {
                return <Contact click={this.handleClick.bind(this)} firstName={x.firstName} lastName={x.lastName} key={i} index={i}/>
            }),
            details: <ContactDetails person={contactsData[currentId]}/>
        }
    }
    handleClick(event) {
        let id = event.target.parentNode.getAttribute('data-id');
        if (id == null) {
            id = event.target.getAttribute('data-id');
        }
        currentId = Number(id);
        this.setState(state => ({
            details: <ContactDetails person={contactsData[currentId]}/>
        }));
    }
    render() {
        return (
            <div className="container">
                <Header />
                <div id="book">
                    <div id="list">
                        <h1>Contacts</h1>
                        <div className="content">
                            {this.state.contacts}
                        </div>
                    </div>
                    <div id="details">
                        <h1>Details</h1>
                        {this.state.details}
                    </div>
                </div>
                <Footer />
            </div>
        );
    }
}

class App extends Component {
    render() {
        return (
            <Content />
        );
    }
}

export default App;
