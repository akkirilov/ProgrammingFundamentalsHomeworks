import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

import WithNotifications from '../../hocs/WithNotifications';
import requester from '../../infrastructure/requesterFetch';
import observer from '../../infrastructure/observer';

class LoginFormBase extends Component {

    constructor(props) {
        super(props);

        this.state = {  
            userData: {},
            view: ''
        }

        this.handleOnClick = this.handleOnClick.bind(this);
        this.handleOnChange = this.handleOnChange.bind(this);
    }

    componentDidMount() {
        let view = (
                <form id="loginForm" method="POST">
                    <h2>Sign In</h2>
                    <label>Username:</label>
                    <input name="username" type="text" onChange={this.handleOnChange} />
                    <label>Password:</label>
                    <input name="password" type="password" onChange={this.handleOnChange} />
                    <input id="btnLogin" value="Sign In" type="submit" onClick={this.handleOnClick} />
                </form>
            );
        if (sessionStorage.getItem('authtoken')) {
            view = <Redirect to="/catalog" />;
        }
        this.setState({ view });
    }

    handleOnClick(event) {
        event.preventDefault();
        if (sessionStorage.getItem('authtoken')) {
            this.props.error('You are already logged!');
            return;
        }
        requester.post('user', 'login', 'basic', this.state.userData)
        .then(res => res.json()) 
        .then(res => {
            if (res.error) {
                this.props.error(res.description);
            } else {
                observer.trigger(observer.events.loginUser, res.username);
                sessionStorage.setItem('authtoken', res._kmd.authtoken);
                sessionStorage.setItem('userId', res._id);
                sessionStorage.setItem('username', res.username);
                this.props.info('Successfull login!');
                if (res.role === 'admin') {
                    observer.setAdmin();
                }
                this.setState({
                    view: <Redirect to="/catalog" />
                })
            }
        }).catch(err => this.props.error(err))
    }

    handleOnChange(event) {
        let userData = this.state.userData;
        userData[event.target.name] = event.target.value;
        this.setState({ userData });
    }

    render() {
        return (this.state.view);
    }

}

const LoginForm = WithNotifications(LoginFormBase);

export default LoginForm;
