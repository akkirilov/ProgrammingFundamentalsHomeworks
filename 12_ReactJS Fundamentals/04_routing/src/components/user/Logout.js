import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

import WithNotifications from '../../hocs/WithNotifications'
import observer from '../../infrastructure/observer';

class LogoutBase extends Component {

    componentDidMount() {
        if (!sessionStorage.getItem('authtoken')) {
            this.props.error('You are not logged!');
            return;
        }
        sessionStorage.clear();
        observer.trigger(observer.events.logoutUser);
        this.props.info('Succesfull logout!');
    }

    render () {
        return <Redirect to="/" />
    }
}

const Logout = WithNotifications(LogoutBase);

export default Logout;
