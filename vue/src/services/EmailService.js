import emailjs from '@emailjs/browser'

emailjs.init("CLJf1k62ICqvoFDNx");

export default {

    sendEmail(email, name, book) {
        let details = {
            person_name: name,
            book_title: book.title,
            book_author: book.author,
            to_email: email,
            image: book.coverLink

        };

        emailjs.send('service_m9jff4d', 'template_kuahfns', details);


        }
}
