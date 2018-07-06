import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import observer from '../../infrastructure/observer';

import '../../styles/header.css';

export default class Header extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            username: null
        }
        
        this.login = this.login.bind(this);
        this.logout = this.logout.bind(this);

        observer.subscribe(observer.events.loginUser, this.login)
        observer.subscribe(observer.events.logoutUser, this.logout)
    }

    componentDidMount() {
        if (sessionStorage.getItem('username')) {
            this.setState({ username: sessionStorage.getItem('username') })
        }
    }

    login(username) {
        this.setState({ username })
    }

    logout() {
        this.setState({ username: null })
    }
    
    render() {
        return (
            <header>
                <span className="logo">☃</span><span className="header">SeenIt</span>
                {this.state.username ? <div id="profile"><span>{this.state.username}</span>|<Link to="/logout">logout</Link></div> : ''}
            </header>
        );
    }
}
