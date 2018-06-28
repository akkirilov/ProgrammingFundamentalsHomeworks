import React from 'react';

export default class Roster extends React.Component {
    render = () => {
        return (
            <div className="padding-right" onClick={()=>this.props.select(this.props.id)}>
                <p><img className="thumb" src={this.props.url} alt="roster" /></p>
                <p>Name: <strong>{this.props.name}</strong></p>
            </div>
        );
    }
}