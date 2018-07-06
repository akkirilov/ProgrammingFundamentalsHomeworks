import React, { Component } from 'react';

import '../../styles/post.css';
import '../../styles/comments.css';

import WithNotifications from '../../hocs/WithNotifications'
import WithLoading from '../../hocs/WithLoading'
import requester from '../../infrastructure/requesterFetch';
import Post from './Post';

class CatalogBase extends Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        }
    }

    render () {
        return (
            <section id="viewCatalog">
                <div className="posts">
                    {this.props.data.map(x => (<Post key={x._id} data={x} />))}
                </div>
            </section>
        )
    }
}

const CatalogWithNotification = WithNotifications(CatalogBase);
const Catalog = WithLoading(CatalogWithNotification);

export default Catalog;
