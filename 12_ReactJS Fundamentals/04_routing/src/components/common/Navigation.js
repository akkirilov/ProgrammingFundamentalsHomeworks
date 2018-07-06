import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import observer from '../../infrastructure/observer';

import '../../styles/menu.css';

export default class Navigation extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            username: null,
            defaultView: (
                <div id="menu">
                    <div className="title">Navigation</div>
                    <Link className="nav" to="/catalog">Catalog</Link>
                    <Link className="nav" to="/create">Submit Link</Link>
                    <Link className="nav" to="/myPosts">My Posts</Link>
                </div>),
            view: null
        }
        
        this.login = this.login.bind(this);
        this.logout = this.logout.bind(this);

        observer.subscribe(observer.events.loginUser, this.login)
        observer.subscribe(observer.events.logoutUser, this.logout)
    }

    componentDidMount() {
        if (this.state.username) {
            this.setState({ view: this.state.defaultView })
        } else {
            this.setState({ view: null })
        }
    }

    login(username) {
        this.setState({ username })
    }

    logout() {
        this.setState({ username: null, view: null })
    }
    
    render() {
        return this.state.username ? this.state.defaultView : null;
    }
}
