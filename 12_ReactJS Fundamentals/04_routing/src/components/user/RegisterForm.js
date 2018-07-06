import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

import WithNotifications from '../../hocs/WithNotifications';
import requester from '../../infrastructure/requesterFetch';
import observer from '../../infrastructure/observer';

class RegisterFormBase extends Component {

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
            <form id="registerForm" method="POST">
                <h2>Register</h2>
                <label>Username:</label>
                <input name="username" type="text" onChange={this.handleOnChange} />
                <label>Password:</label>
                <input name="password" type="password" onChange={this.handleOnChange} />
                <label>Repeat Password:</label>
                <input name="repeatPass" type="password" onChange={this.handleOnChange} />
                <input id="btnRegister" value="Sign Up" type="submit" onClick={this.handleOnClick} />
            </form>
            );
            if (sessionStorage.getItem('authtoken')) {
                view = <Redirect to="/catalog" />;
                return;
            }
        this.setState({ view });
    }

    handleOnClick(event) {
        event.preventDefault();
        if (sessionStorage.getItem('authtoken')) {
            this.props.error('You are already logged!');
            return;
        }

        if (this.state.userData.password !== this.state.userData.repeatPass) {
            this.props.error('Passwords did not match!');
            return;
        }

        let user = {};
        user.username = this.state.userData.username;
        user.password = this.state.userData.password;
        user.role = 'user';

        requester.post('user', '', 'basic', user)
        .then(res => res.json()) 
        .then(res => {
            if (res.error) {
                this.props.error(res.description);
            } else {
                console.log(res);
                observer.trigger(observer.events.loginUser, res.username);
                sessionStorage.setItem('authtoken', res._kmd.authtoken);
                sessionStorage.setItem('userId', res._id);
                sessionStorage.setItem('username', res.username);
                this.props.info('Successfull registrartion!');
                this.setState({
                    view: <Redirect to="/catalog" />
                })
            }
        })
        .catch(err => this.props.error(err.JSON.description))
    }

    handleOnChange(event) {
        let userData = this.state.userData;
        userData[event.target.name] = event.target.value;
        this.setState({ userData });
    }

    render() {
        return this.state.view
    }

}

const RegisterForm = WithNotifications(RegisterFormBase);

export default RegisterForm;
