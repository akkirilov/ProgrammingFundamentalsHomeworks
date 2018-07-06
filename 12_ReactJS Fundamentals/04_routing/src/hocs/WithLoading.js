import React, {
    Component
} from 'react';

function WithLoading(WrappedComponent) {

    return class extends React.Component {
        constructor(props) {
            super(props);
            this.state = {
                ready: false,
                data: []
            };
        }

        componentDidMount() {
            console.log(this.props)
            this.props.request().then(data => data.json()).then(data => this.receiveData(data));
        }

        receiveData(data) {
            this.setState({
                ready: true,
                data
            });
        }

        render() {
            if (this.state.ready) {
                return <WrappedComponent data = { this.state.data } { ...this.props } />;

            }
            return ( <div className = "loading" > Loading & hellip; </div>);
        };
    }
}


export default WithLoading;