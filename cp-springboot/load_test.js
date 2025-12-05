import http from 'k6/http';
import { check } from 'k6'; // لاحظ أننا حذفنا sleep

export const options = {
    stages: [
        { duration: '10s', target: 100 },  // تسخين سريع
        { duration: '1m', target: 40 },  // هجوم بـ 1000 مستخدم في نفس اللحظة!
        { duration: '10s', target: 0 },
    ],
};

export default function () {
    const res = http.get('http://localhost:8080/api/users');
    check(res, { 'status was 200': (r) => r.status == 200 });
    // حذفنا sleep(1) <-- الآن الهجوم متواصل بدون توقف
}