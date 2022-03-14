import React from 'react';
import {Button, Menu, Tyopgraphy, Avatar, Typography} from 'antd';
import { Link } from 'react-router-dom';
import { HomeOutlined, LoginOutlined, SearchOutlined, UsergroupAddOutlined } from '@ant-design/icons';

import icon from '../images/brewery.png'

const Navbar = () => {
  return (
    <div className="nav-container">
    <div className="logo-container">
            <Avatar src={icon} size="large" />
            <Typography.Title level={2} className="logo">
                <Link to="/">Brewery Finder</Link>
                </Typography.Title>
                
    </div>
    <Menu theme="dark">
        <Menu.Item icon={<HomeOutlined />}>
            <Link to="/">Home</Link>
        </Menu.Item>
        <Menu.Item icon={<SearchOutlined />}>
            <Link to="/breweries">Breweries</Link>
        </Menu.Item>
        <Menu.Item icon={<UsergroupAddOutlined />}>
            <Link to="/registration">Registration</Link>
        </Menu.Item>
        <Menu.Item icon={<LoginOutlined />}>
            <Link to="/login">Login</Link>
        </Menu.Item>
    </Menu>
    </div>
  )
}

export default Navbar;