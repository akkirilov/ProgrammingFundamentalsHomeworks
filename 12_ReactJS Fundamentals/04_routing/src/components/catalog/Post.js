import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import observer from '../../infrastructure/observer';

class Post extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isAuthorized: false
        }
    }

    componentDidMount() {
        let isAuthorized = false;
        if (observer.isAdmin === true || sessionStorage.getItem('userId') === this.props.data._acl.creator ) {
            isAuthorized = true; 
            this.setState({isAuthorized});
        }
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
        return (
            <article className="post">
                <div className="col rank">
                    <span>1</span>
                </div>
                <div className="col thumbnail">
                    <a href={this.props.data.url}>
                        <img src={this.props.data.imageUrl} alt="kartinka"/>
                    </a>
                </div>
                <div className="post-content">
                    <div className="title">
                         <a href={this.props.data.url}>
                            {this.props.data.title}
                        </a>
                    </div>
                    <div className="details">
                        <div className="info">
                            {this.calcTime(this.props.data._kmd.ect)}
                        </div>
                        <div className="controls">
                            <ul>
                                <Link className="action commentsLink" to={'/posts/' + this.props.data._id}>comments</Link>
                                {this.state.isAuthorized ? (<Link className="action editLink" to={'/posts/edit/' + this.props.data._id}>edit</Link>) : ''}
                                {this.state.isAuthorized ? (<Link className="action deleteLink" to={'/posts/delete/' + this.props.data._id}>delete</Link>) : ''}
                            </ul>
                        </div>
                    </div>
                </div>
            </article>
        )
    }
}

export default Post;
