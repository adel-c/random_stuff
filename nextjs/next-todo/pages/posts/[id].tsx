import Layout from '../../components/layout';
import { getAllPostIds, getPostData, PostData } from '../../lib/posts';
import Head from 'next/head';

export default function Post({ postData }:any) {
  return (
    
    <Layout>
      <Head>
        <title>{postData.title}</title>
      </Head>
      {postData.title}
      <br />
      {postData.id}
      <br />
      {postData.date}
      <br/>
      <div dangerouslySetInnerHTML={{ __html: postData.contentHtml }} />
    </Layout>
  );
}



export async function getStaticPaths() {
  const paths = getAllPostIds();
  return {
    paths,
    fallback: false,
  };
}
export async function getStaticProps({ params }:{params:{id:string}}) {
  const postData =await getPostData(params.id);
  return {
    props: {
      postData,
    },
  };
}