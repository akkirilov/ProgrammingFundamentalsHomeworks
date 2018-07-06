import React from 'react';

function WithNotifications(WrappedComponent) {

    const TIMEOUT = 5000;
    const DEFAULT_NOTIFICATION = '';

    return class extends React.Component {
        constructor(props) {
            super(props);

            this.state = { 
                notification: DEFAULT_NOTIFICATION    
            };

            this.error = this.error.bind(this);
            this.info = this.info.bind(this);
        }

        error(message) {
            this.setState({
                notification: (
                    <div id="notifications">
                        <div id="errorBox" className="notification"><span>{message}</span></div>
                    </div>
            )});
            setTimeout(() => {
                this.setState({notification: DEFAULT_NOTIFICATION})
            }, TIMEOUT);
        }

        info(message) {
            this.setState({
                notification: (
                    <div id="notifications">
                        <div id="infoBox" className="notification"><span>{message}</span></div>
                    </div>
            )});
            setTimeout(() => {
                this.setState({notification: DEFAULT_NOTIFICATION})
            }, TIMEOUT);
        }

        render() {
            return (
                <div>
                    {this.state.notification}
                    <WrappedComponent { ...this.props } error={this.error} info={this.info}/>
                </div>
            )
        }
    };
}

export default WithNotifications;
