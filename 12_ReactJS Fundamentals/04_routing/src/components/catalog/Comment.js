import React, { Component } from 'react';

class Comment extends Component {

    constructor(props) {
        super(props);
        this.state = {
            view: ''
        }
    }

    componentDidMount() {
        this.setState({view: (
            <article className="post post-content">
                <p>{this.props.data.content}</p>
                <div className="info">
                    {this.calcTime(this.props.data._kmd.ect) + ' by ' + this.props.data.author} 
                    {this.props.isAuthorized 
                    ? <span> | <a href ="/deleteComment" onClick={(e) => this.props.func(e, this.props.data._id)} > delete </a></span>
                    : ''}
                </div>
            </article>
        )})
    }

    calcTime(dateIsoFormat) {
        let diff = new Date - (new Date(dateIsoFormat));
        diff = Math.floor(diff / 60000);
        if (diff < 1) return 'submitted less than a minute';
        if (diff < 60) return 'submitted ' + diff + ' minute' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 60);
        if (diff < 24) return 'submitted ' + diff + ' hour' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 24);
        if (diff < 30) return 'submitted ' + diff + ' day' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 30);
        if (diff < 12) return 'submitted ' + diff + ' month' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 12);
        return 'submitted ' + diff + ' year' + pluralize(diff) + ' ago';

        function pluralize(value) {
            if (value !== 1) return 's';
            else return '';
        }
    }
    
    render () {
        return this.state.view;
    }
}

export default Comment;
