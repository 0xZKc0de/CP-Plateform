import http from 'k6/http';
import { check } from 'k6';

export const options = {
    stages: [
        { duration: '10s', target: 100 },
        { duration: '1m', target: 40 },  // 40 users
        { duration: '10s', target: 0 },
    ],
};

export default function () {
    const res = http.get('http://localhost:8081/api/users');
    check(res, { 'status was 200': (r) => r.status == 200 });
}