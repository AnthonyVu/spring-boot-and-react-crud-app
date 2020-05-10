import axios from 'axios';

const baseURL = 'http://localhost:8080/api/v1/blogs'

const getAll = async () => {
    console.log('getting all blogs')
    const req = await axios.get(baseURL);
    return req.data;
}

const addBlog = async (object) => {
    console.log('adding blog')
    const req = await axios.post(baseURL, object)
    return req.data
}

const removeBlog = async (id) => {
    console.log('deleting blog')
    const req = await axios.delete(`${baseURL}/${id}`)
    return req.data
}

const updateBlog = async (id, object) => {
    console.log('updating blog')
    const req = await axios.put(`${baseURL}/${id}`, object)
    return req.data
}

export default { getAll, addBlog, removeBlog, updateBlog}