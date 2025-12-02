import http from 'k6/http';
import { sleep, check } from 'k6';

// 1. إعدادات الاختبار (Options)
export const options = {
    // مراحل الهجوم (Stages)
    stages: [
        { duration: '30s', target: 20 },  // تسخين: الصعود إلى 20 مستخدم خلال 30 ثانية
        { duration: '1m', target: 100 },  // هجوم: الصعود إلى 100 مستخدم والبقاء لمدة دقيقة
        { duration: '30s', target: 0 },   // تبريد: النزول إلى 0 مستخدم
    ],
    // (اختياري) عتبة النجاح: يجب أن تفشل الطلبات بنسبة أقل من 1%
    thresholds: {
        http_req_failed: ['rate<0.01'],
    },
};

// 2. دالة التنفيذ (ماذا سيفعل كل مستخدم افتراضي)
export default function () {
    // يطلب قائمة المشاكل
    const res = http.get('http://localhost:8083/api/problems');

    // يتأكد أن الرد كان 200 OK
    check(res, { 'status was 200': (r) => r.status == 200 });

    // ينتظر ثانية واحدة قبل الطلب التالي (يحاكي مستخدماً حقيقياً يقرأ)
    sleep(1);
}